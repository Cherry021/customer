@Library('cicd-pipeline-library') _

pipeline{
    agent any
    stages{
        stage('Git Checkout'){
            steps{
                gitCheckout(branch: 'main',url: 'https://github.com/Cherry021/customer.git')
            }
        }
        stage('Build'){
            steps{
                mavenTest()
            }
        }
    }
}