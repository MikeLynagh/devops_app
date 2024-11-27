pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/MikeLynagh/devops_app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test' // Run unit tests
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true
            }
        }

        stage('Approval') {
            steps {
                input message: 'Deploy to production?', ok: 'Deploy'
            }
        }

        stage('Deploy') {
            steps {
                sshagent(['jenkins-ssh-key']) {
                    sh '''
                        # Copy WAR file to VM
                        scp -P 2222 target/web-app-0.0.1-SNAPSHOT.war mike@localhost:/home/mike/
                        
                        # SSH into VM and move WAR file to Tomcat directory
                        ssh -p 2222 mike@localhost "sudo cp /home/mike/web-app-0.0.1-SNAPSHOT.war /var/lib/tomcat9/webapps/ && sudo systemctl restart tomcat9"
                    '''
                }
            }
        }
    }
}