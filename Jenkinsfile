pipeline {
  agent any

  environment {
    JENKINS_URL = 'http://localhost:8080'         // Cambia si es necesario
    NEW_JOB_NAME = 'folder1/job-creado-con-curl'
    JENKINS_USER = 'miguel'                        // Usuario Jenkins
    JENKINS_TOKEN = '1132f14ba2dc278701ccf951de27e69289'               // Token/API key
  }

  stages {
    stage('Crear Job con curl') {
      steps {
        bat '''
          curl -X POST -u "%JENKINS_USER%:%JENKINS_TOKEN%" ^
            -H "Content-Type: application/xml" ^
            --data-binary @config.xml ^
            "%JENKINS_URL%/createItem?name=%NEW_JOB_NAME%"
        '''
      }
    }
  }
}
