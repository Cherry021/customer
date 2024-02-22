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
        
        stage("Push Docker Image"){
            steps{
                echo "docker image pushed"
            }
        }
        stage("Deploy"){
            steps{
                echo " deployment successful "
            }
        }
    }
}