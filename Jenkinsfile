@Library('cicd-pipeline-library') _

pipeline{
    agent any
    parameters{
        choice(name:'Action',choices:'create\nvalidate',description:'Choose any Action')
    }
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
        stage('Integration Tests'){
            when{
                expression{
                    params.Action == 'create'
                }
            }
            steps{
                mavenIntTest()
            }
        }
        stage('Static Code Analysis'){
            staticCodeAnalysis()
        }
    }
}