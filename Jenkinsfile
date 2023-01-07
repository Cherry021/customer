pipeline{
    agent any
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
                        def mvnHome = tool name: 'Apache Maven 3.6.3', type: 'maven'
                        sh 'chmod +x ${mvnHome}/bin/mvn'
                        sh '${mvnHome}/bin/mvn sonarqube'
                    }
                }
            }
        }
    }
}
