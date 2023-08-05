@Library('lol-pipeline-library') _

pipeline{
    agent any
    parameters{
        string(name:'UserDetails',description:'User Details',defaultValue:'ch20140270')
        string(name:'ImageName',description:'Name of Image',defaultValue:'customer')
        string(name:'ImageTag',description:'Name of Image Tag',defaultValue:'v1')
    }
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
        stage('Quality Status'){
            steps{
                qualityStatus()
            }
        }
        stage('Build'){
            steps{
                mavenBuild()
            }
        }
        stage('Docker Build'){
            steps{
                dockerBuild("${params.UserDetails}","${params.ImageName}","${params.ImageTag}")
            }
        }
    }
}