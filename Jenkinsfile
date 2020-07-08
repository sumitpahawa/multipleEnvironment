pipeline {
    // master executor should be set to 0
    agent any
       stages {
       
        stage('Smoke') {
         
            steps {
                //sh
                sh "mvn clean test -p Smoke"
            }
        }
        stage('Sanity') {
            steps {
                //sh
                sh "mvn clean test -p Sanity"
            }
        }
          stage('Regress') {
            steps {
                //sh
         sh "mvn clean test -p Regress"
            }
        }
        stage('Regression') {
            steps {
			sh "mvn clean test -p Regression"
			    }                           
            }
        }
  
     post{
        always {
            archiveArtifacts artifacts: 'output/**'
            sh "docker-compose down"
        }
    }
      }
   