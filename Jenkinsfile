pipeline{
    agent any
    environment{
        VERSION = "${env.BUILD_ID}"
    }
    stages {
        stage("docker build & push") {
            steps{
                script{
                    withCredentials([string(credentialsId: 'nexus_password', variable: 'nexus_password')]) {
                        sh '''
                            docker build -t 34.136.85.102:8083/springapp:${VERSION} .
                            docker login -u admin -p $nexus_password http://34.136.85.102:8083
                            docker push 34.136.85.102:8083/springapp:${VERSION}
                            docker rmi 34.136.85.102:8083/springapp:${VERSION}
                        '''
                    }
                }
            }
        }
    }

}
