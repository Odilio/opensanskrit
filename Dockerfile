# Usar a imagem oficial do Java 19
FROM openjdk:19-jdk-slim

# VARIÁVEIS DE AMBIENTE
# - JAVA_OPTS: Opções adicionais para a JVM. Você pode definir qualquer opção de JVM aqui, se necessário.
ENV JAVA_OPTS=""

# Copie o JAR construído para a imagem
COPY --from=build /app/target/sanscrito-1.0.0.jar /app/sanscrito.jar

# Exponha a porta que sua aplicação utiliza (ajuste conforme necessário)
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "/app/sanscrito.jar"]
