import jenkins.model.*

def jobName = "pipeline-creado-xml"
def xml = '''
<?xml version='1.1' encoding='UTF-8'?>
<flow-definition plugin="workflow-job@1400.v7fd111b_ec82f">
  <description>Job creado desde XML</description>
  <keepDependencies>false</keepDependencies>
  <properties>
    <hudson.plugins.jira.JiraProjectProperty plugin="jira@3.13"/>
    <com.sonyericsson.rebuild.RebuildSettings plugin="rebuild@332.va_1ee476d8f6d">
      <autoRebuild>false</autoRebuild>
      <rebuildDisabled>false</rebuildDisabled>
    </com.sonyericsson.rebuild.RebuildSettings>
  </properties>
  <definition class="org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition" plugin="workflow-cps@3953.v19f11da_8d2f2">
    <script>
      pipeline {
        agent any
        stages {
          stage('Hello') {
            steps {
              echo 'Hola desde un job creado por XML'
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

def stream = new ByteArrayInputStream(xml.getBytes("UTF-8"))
Jenkins.instance.createProjectFromXML(jobName, stream)