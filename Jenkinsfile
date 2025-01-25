pipeline {
    agent any
    
    environment {
        REPO_URL = 'https://github.com/KeldarWolf/CtaCorriente.git'  // URL del repositorio
        BRANCH = 'main'  // Rama del repositorio
        MAVEN_HOME = 'C:\\apache-maven-3.9.9\\bin'  // Ruta donde está instalado Maven en tu máquina Windows
        PATH = MAVEN_HOME + ';' + env.PATH  // Añadir Maven al PATH
    }

    stages {
        // Etapa 1: Clonación del Repositorio
        stage('Clonar Repositorio') {
            steps {
                git branch: BRANCH, url: REPO_URL
                echo 'Repositorio clonado correctamente'
            }
        }

        // Etapa 2: Verificación de Dependencias
        stage('Verificar Dependencias') {
            steps {
                echo 'Verificando dependencias del proyecto...'
                // Usar mvn.cmd para verificar dependencias
                bat '"C:\\apache-maven-3.9.9\\bin\\mvn.cmd" dependency:tree'
            }
        }

        // Etapa 3: Compilación del Proyecto
        stage('Compilar Proyecto') {
            steps {
                echo 'Compilando el proyecto con Maven...'
                // Usar mvn.cmd para compilar el proyecto
                bat '"C:\\apache-maven-3.9.9\\bin\\mvn.cmd" clean install'
            }
        }

        // Etapa 4: Ejecutar Pruebas
        stage('Ejecutar Pruebas') {
            steps {
                echo 'Ejecutando pruebas del proyecto con Maven...'
                // Usar mvn.cmd para ejecutar las pruebas y generar un reporte XML
                bat '"C:\\apache-maven-3.9.9\\bin\\mvn.cmd" test -Dtestng.groups=smoke -Dsurefire.reportFormat=xml'
            }
        }

        // Etapa 5: Desplegar Proyecto
        stage('Desplegar Proyecto') {
            steps {
                echo 'Desplegando la aplicación...'
                // Comando de despliegue, dependiendo de cómo se maneje en tu proyecto
                // Por ejemplo, puedes copiar archivos al servidor o ejecutar un comando de Docker, etc.
                // bat 'scp -r target/* user@server:/path/to/deploy'
            }
        }
    }

    post {
        success {
            echo 'El pipeline se completó con éxito.'
        }
        failure {
            echo 'El pipeline ha fallado.'
        }
    }
}
