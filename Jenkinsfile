pipeline {
    agent nodo {
    stages {
  	stage('SCM') {
    		checkout scm
  		}
  	stage('SonarQube Analysis') {
    		withSonarQubeEnv() {
      		sh "./gradlew sonar"
    		}
  	}
	
        stage('Compilado de Aplicacion usando') {
            steps {
                sh 'chmod +x build.sh'
		sh 'docker login -u edergm -p Garrido2023+'
                sh './build.sh'
            }
        }
         stage('Despliegue de Aplicacion en Kubernetes') {
            steps {
                sh 'chmod +x kubernetes_deployment.sh'
                sh './kubernetes_deployment.sh'
            }
        }
    }
}
}
