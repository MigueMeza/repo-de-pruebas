pipeline {
  agent any

  environment {
    JENKINS_URL = 'http://localhost:8080'         // Cambia si es necesario
    FOLDER_PATH     = 'folder1/folder2'                 // Ruta de carpetas
    NEW_JOB_NAME    = 'job-creado-con-curl'
    FULL_JOB_PATH   = "${FOLDER_PATH}/${NEW_JOB_NAME}"
    JENKINS_USER = 'miguel'                        // Usuario Jenkins
    JENKINS_TOKEN = '1132f14ba2dc278701ccf951de27e69289'               // Token/API key
  }

  stages {
    stage('crear folder'){
      steps{
        // Crear folder2 dentro de folder1
          bat """
            curl -X POST -u %JENKINS_USER%:%JENKINS_TOKEN% ^
              -H "Content-Type: application/xml" ^
              --data-binary "<com.cloudbees.hudson.plugins.folder.Folder><description>Auto folder</description></com.cloudbees.hudson.plugins.folder.Folder>" ^
              %JENKINS_URL%/job/folder1/createItem?name=folder2
          """
      }
    }
    
    stage('Crear Job con curl') {
      steps {
 
        bat '''
          curl -X POST -u "%JENKINS_USER%:%JENKINS_TOKEN%" ^
            -H "Content-Type: application/xml" ^
            --data-binary @config.xml ^
            "%JENKINS_URL%/job/folder1/job/folder2/createItem?name=%NEW_JOB_NAME%"
        '''
      }
    }

    stage('Ejecutar job') {
      steps {
        bat """
          curl -X POST -u %JENKINS_USER%:%JENKINS_TOKEN% ^
            "%JENKINS_URL%/job/folder1/job/folder2/job/%NEW_JOB_NAME%/build"
        """
      }
    }
  }
}
