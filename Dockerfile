# Openjdk image
FROM openjdk:11

# Define o diretorio de trabalho
WORKDIR /home/proposta

# Copia o arquivo do seu host para o seu local atual
COPY /target/bootcamp-0.0.1-SNAPSHOT.jar proposta.jar

# Executa um comando especifico no container
ENTRYPOINT ["java", "-jar", "proposta.jar"]

# Variaveis de ambiente
ENV DB_URL="jdbc:mysql://host.docker.internal:3306/proposta"

ENV ANALISE_URL="http://host.docker.internal:9999"

ENV CARTAO_URL="http://host.docker.internal:8888"

ENV JAEGER_ENDPOINT="http://host.docker.internal:14268/api/traces"
