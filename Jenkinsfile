pipeline {
    agent none
    stages {
        stage('build') {
            agent {
                label 'linux'
            }
            steps {
                sh 'git init'
                sh 'git pull https://github.com/EderGM/aplicacion.git'
                sh 'chmod +x build.sh'
		            sh 'docker login -u edergm -p Garrido2023+'
                sh './build.sh'
            }
        }
         stage('deploy') {
            agent {
                label 'linux'
            }
            steps {
                sh 'chmod +x kubernetes_deployment.sh'
                sh './kubernetes_deployment.sh'
            }
        }
    }
}
