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
                        # Test SSH connection first
                        ssh -p 2222 -o StrictHostKeyChecking=no mike@192.168.8.142 "echo 'SSH Connection Test Successful'"
                        
                        # If connection works, proceed with deployment
                        scp -P 2222 target/web-app-0.0.1-SNAPSHOT.war mike@192.168.8.142:/home/mike/
                        
                        ssh -p 2222 mike@192.168.8.142 "sudo cp /home/mike/web-app-0.0.1-SNAPSHOT.war /var/lib/tomcat9/webapps/ && sudo systemctl restart tomcat9"
                    '''
                }
            }
        }
    }
}