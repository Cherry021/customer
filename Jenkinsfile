pipeline{
    agent any
    stages{
        stage('build'){
            withMaven(maven: 'mvn') {
                sh "mvn clean package"
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
