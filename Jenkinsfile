pipeline {
    agent none
    stages {
        stage('Compilado de Aplicacion usando') {
            agent {
                label 'roler'
            }
            steps {
                sh 'chmod +x build.sh'
		sh 'docker login -u edergm -p Garrido2023+'
                sh './build.sh'
            }
        }
         stage('Despliegue de Aplicacion en Kubernetes') {
            agent {
                label 'roler'
            }
            steps {
                sh 'chmod +x kubernetes_deployment.sh'
                sh './kubernetes_deployment.sh'
            }
        }
    }
}
