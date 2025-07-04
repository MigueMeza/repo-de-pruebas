def call() {
  agent any
  pipeline {
      stages {
        stage('Build') {
          steps {
            echo "Building"
          }
        }
      stage('Test') {
        steps {
          echo "Testing"
        }
      }
    }
  }
}
