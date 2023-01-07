pipeline{
    agent any
    tools {
        maven 'M3'
    }
    stages{
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
