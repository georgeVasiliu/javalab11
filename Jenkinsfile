pipeline {
  agent any
  stages {
    stage('cd to test folder') {
      steps {
        dir(path: 'D:/jenkins_local/testing_envirnoment')
      }
    }
    stage('build a job') {
      steps {
        build 'job_test'
      }
    }
  }
}