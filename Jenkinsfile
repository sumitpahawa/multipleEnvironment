pipeline {
    // master executor should be set to 0
    agent any
       stages {
       
        stage('Smoke') {
         
            steps {
                //sh
                sh "mvn clean test -P Smoke"
            }
        }
        stage('Sanity') {
            steps {
                //sh
                sh "mvn clean test -P Sanity"
            }
        }
          stage('Regress') {
            steps {
                //sh
         sh "mvn clean test -P Regress"
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
            }
        }
        stage('Regression') {
            steps {
			sh "mvn clean test -P Regression"
			    }                           
            }
        }
  
     post{
        always {
            archiveArtifacts artifacts: 'output/**'
   
        }
    }
      }
   