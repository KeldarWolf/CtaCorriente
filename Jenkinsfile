pipeline {
    agent any
    
    environment {
        REPO_URL = 'https://github.com/KeldarWolf/CtaCorriente.git'  // URL del repositorio
        BRANCH = 'main'  // Rama del repositorio
        MAVEN_HOME = '/usr/local/maven'  // Ruta donde está instalado Maven, ajusta si es necesario
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
                // Comando de Maven para verificar dependencias o cualquier otra validación que requieras
                sh "${MAVEN_HOME}/bin/mvn dependency:tree"
            }
        }

        // Etapa 3: Compilación del Proyecto
        stage('Compilar Proyecto') {
            steps {
                echo 'Compilando el proyecto con Maven...'
                // Ejecutar Maven para construir el proyecto
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        }

        // Etapa 4: Ejecutar Pruebas
        stage('Ejecutar Pruebas') {
            steps {
                echo 'Ejecutando pruebas del proyecto con Maven...'
                // Ejecutar las pruebas con Maven y guardar los resultados en un archivo XML
                sh "${MAVEN_HOME}/bin/mvn test -Dtestng.groups=smoke -Dsurefire.reportFormat=xml"
            }
        }

        // Etapa 5: Desplegar Proyecto
        stage('Desplegar Proyecto') {
            steps {
                echo 'Desplegando la aplicación...'
                // Comando de despliegue, dependiendo de cómo se maneje en tu proyecto
                // Por ejemplo, puedes copiar archivos al servidor o ejecutar un comando de Docker, etc.
                // sh 'scp -r target/* user@server:/path/to/deploy'
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
