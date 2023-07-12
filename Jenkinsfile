pipeline {
    agent none
    stages {
        stage('build') {
            agent {
                label 'roler'
            }
            steps {
                sh 'chmod +x build.sh'
		sh 'docker login -u edergm -p Garrido2023+'
                sh './build.sh'
            }
        }
         stage('deploy') {
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
