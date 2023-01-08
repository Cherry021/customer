pipeline{
    agent any
    environment {
        PATH = "/usr/share/maven/bin:$PATH"
    }
    stages{
        stage("build code"){
            steps{
                sh "mvn clean install"
            }
        }
        stage("sonar quality check"){
            agent {
                docker {
                    image "openjdk:11"
                }
            }
            steps{
                script{
                    withSonarQubeEnv(credentialsId: 'sonar-password') {
                        sh 'chmod +x mvn'
                        sh 'mvn sonarqube'
                    }
                }
            }
        }
    }
}
