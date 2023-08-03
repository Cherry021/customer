@Library('my-pipeline-library') _

pipeline{
    agent any
    stages{
        stage("Git Checkout"){
            steps{
                gitCheckout(url:'https://github.com/Cherry021/customer.git', branch:'main')
            }
        }
        stage("Testing"){
            steps{
                mvnTest()
            }
        }
        stage("Sonar Testing"){
            steps{
                sonarTetsing()
            }
        }
        stage("Build"){
            steps{
                mvnIntTest()
            }
        }
    }
}