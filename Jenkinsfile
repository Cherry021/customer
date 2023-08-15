pipeline{
    agent any
    tools{
        maven "Maven"
    }
    environment{
        PROJECT_ID = 'storied-cider-394305'
        CLUSTER_NAME = 'cherryk8s' 
        LOCATION = 'us-central1-c'
        CREDENTIALS_ID = 'kubernetes'
    }
    stages{
        stage("Git Checkout"){
            steps{
                checkout scm
            }
        }
        stage("Build"){
            steps{
                sh "mvn clean package"
            }
        }
        stage("Test"){
            steps{
                sh "mvn test"
            }
        }
        stage("Build Docker Image"){
            steps{
                script{
                    myImage = docker.build("ch20140270/customer:${env.BUILD_ID}")
                }
            }
        }
        stage("Push Docker Image"){
            steps{
                script{
                    withCredentials([string(credentialsId:'docker-hub-login',variable:'dockerhub')]){
                        sh "docker login -u ch20140270 -p ${dockerhub}"
                    }
                    myImage.push("${env.BUILD_ID}")
                }
            }
        }
        stage("Deploy"){
            steps{
                sh "sed -i 's/tagversion/${env.BUILD_ID}/g' service.yaml"
                sh "sed -i 's/tagversion/${env.BUILD_ID}/g' deploy.yaml"
                step([
                    $class: 'KubernetesEngineBuilder',
                    projectId: env.PROJECT_ID,
                    clusterName: env.CLUSTER_NAME,
                    location: env.LOCATION,
                    manifestPattern: 'service.yaml',
                    credentialsId: env.CREDENTIAL_ID,
                    verifyDeployment: true
                ])
                step([
                    $class: 'KubernetesEngineBuilder',
                    projectId: env.PROJECT_ID,
                    clusterName: env.CLUSTER_NAME,
                    location: env.LOCATION,
                    manifestPattern: 'deploy.yaml',
                    credentialsId: env.CREDENTIAL_ID,
                    verifyDeployment: true
                ])
            }
        }
    }
}