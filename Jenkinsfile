@Library('lol-pipeline-library') _

pipeline{
    agent any
    stages(){
        stage('Git Checkout'){
            steps{
                gitCheckout()
            }
        }
        stage('Tesing'){
            steps{
                mavenTest()
            }
        }
        stage('Sonar Testing'){
            steps{
                sonarCheck()
            }
        }
        stage('Build'){
            steps{
                mavenBuild()
            }
        }
    }
}