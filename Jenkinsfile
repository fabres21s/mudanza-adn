pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle5.6_Centos' //Preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
		checkout([
				$class: 'GitSCM', 
				branches: [[name: '*/master']], 
				doGenerateSubmoduleConfigurations: false, 
				extensions: [], 
				gitTool: 'Git_Centos', 
				submoduleCfg: [], 
				userRemoteConfigs: [[
				credentialsId: 'GitHub_fabio.sierra', 
					url:'https://github.com/fabres21s/mudanza-adn'
				]]
			])
      }
    }

	stage('Build project') {
		steps {
			echo "------------>Building project microservicio<------------"
				sh 'gradle --b ./java-arquitectura-hexagonal/microservicio/build.gradle clean'
				sh 'gradle --b ./java-arquitectura-hexagonal/microservicio/build.gradle build'
								
		}
	}
          
	stage('Compile & Unit Tests') {
        steps {
            echo "--------------->Unit Tests microservicio<--------"
            sh 'gradle --b ./java-arquitectura-hexagonal/microservicio/build.gradle test'
            sh 'gradle --b ./java-arquitectura-hexagonal/microservicio/build.gradle jacocoTestReport'

        }
    }
    
	stage('Static Code Analysys'){
        steps {
            echo '----------------->Analisis de Código estático<-----------------'
            withSonarQubeEnv('Sonar'){
				sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
			}
		}
    }
	
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo '----------->success<-----------'
    }
    failure {
      echo 'This will run only if failed'
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
  