pipeline {
  environment {
    dockerimagename = "aplicacion"
    dockerImage = ""
  }
  agent any
  stages {
    stage('Build image') {
      steps{
        script {
          mkdir aplicacion
          cd aplicacion
          gradle bootjar
          dockerImage = docker.build dockerimagename
        }
      }
    }
    stage('Pushing Image') {
      environment {
               registryCredential = 'dockerhub'
           }
      steps{
        script {
          docker.withRegistry( 'https://hub.docker.com/repositories/edergm', registryCredential ) {
            dockerImage.push("latest")
          }
        }
      }
    }
    stage('Deploying React.js container to Kubernetes') {
      steps {
        script {
          kubernetesDeploy(configs: "deployment.yaml", "service.yaml")
        }
      }
    }
  }
}
