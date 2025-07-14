pipeline {
  agent any
  environment {
    JENKINS_URL = 'http://localhost:8080'   // Cambia si tu Jenkins está en otro host
    JENKINS_USER = 'miguel'
    JENKINS_TOKEN = '123'
    NEW_JOB_NAME = 'job-creado-desde-curl'
  }
  stages {
    stage('Crear Job') {
      steps {
        writeFile file: 'config.xml', text: '''
<?xml version='1.1' encoding='UTF-8'?>
<flow-definition plugin="workflow-job">
  <description>Job creado desde API</description>
  <keepDependencies>false</keepDependencies>
  <properties/>
  <definition class="org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition" plugin="workflow-cps">
    <script>
      pipeline {
        agent any
        stages {
          stage('Hello') {
            steps {
              echo 'Hola desde un job creado por otro job'
            }
          }
        }
      }
    </script>
    <sandbox>true</sandbox>
  </definition>
  <triggers/>
  <disabled>false</disabled>
</flow-definition>
'''
        sh '''
          curl -X POST -u "$JENKINS_USER:$JENKINS_TOKEN" \
            -H "Content-Type: application/xml" \
            --data-binary @config.xml \
            "$JENKINS_URL/createItem?name=$NEW_JOB_NAME"
        '''
      }
    }
  }
}
