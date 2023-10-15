# Microservice sanscrito
Exemplo de microsserviço utilizando o padrão da Arquitetura Hexagonal.

Antes de começar, verifique se você deveria utilizar esse projeto na [wiki](https://wiki.softfocus.com.br/pt-br/internal/desenvolvimento/microservices/quando-usar-arquitetura-hexagonal)
## Pacotes
[Adapters:](src/main/kotlin/br/com/softfocus/base/adapters)
Pacote relacionado a padrões de comunicação que esta aplicação tem com outras
Nesta camada temos os **_Mappers_**, os casos de uso de cada entidade

[Application:](src/main/kotlin/br/com/softfocus/base/application)
Pacote que contém a camada com lógica de regras de negócio, totalmente desacoplado, apenas trabalhando com os mappers.

[Ports:](src/main/kotlin/br/com/softfocus/base/ports)
Pacote que contém as **_interfaces_** que permitem o desacoplamento da camada de **_adapters_** e **_application_**.

## Executando Localmente
Para executar localmente é necessario ter instalado o k8s e alguma ferramenta de clusterização,
podendo ser utilizados o [minikube](https://minikube.sigs.k8s.io/docs/start/), ou [kind](https://kind.sigs.k8s.io/).

1. Crie o wrapper do maven, utilizando o comando `mvn wrapper:wrapper`
2. Crie uma imagem com o JIB usando o comando `mvn compile jib:dockerBuild`

Com a imagem montada, podemos efetuar o deploy ou executar em modo dev
usando a ferramenta [skaffold](https://skaffold.dev/) com o comando `skaffold dev --port-forward`
(ou simplesmente `skaf` se já tiver os aliases de desenvolvimento).

Para saber a porta disponível para utilização por este MS, pode ser consultado o arquivo de
propriedades do [gateway](https://bitbucket.org/softfocusbr/microservice-properties-v2/src/local/gateway.yml),
na tag **_softfocus.routes_**

<a id="eof"></a>
Para testar de maneira efetiva e utilizar o [microservice-config](https://bitbucket.org/softfocusbr/microservice-config-v2/),
o arquivo **_application.yml_** deve ser removido do projeto, e um novo arquivo com o nome do
microsserviço (ex: microservice-hexagonal.yml) deve ser criado na branch local do projeto
[microservice-properties-v2](https://bitbucket.org/softfocusbr/microservice-properties-v2/).

Mais informações detalhadas na [wiki](https://wiki.softfocus.com.br/pt-br/internal/desenvolvimento/microservices/primeiros-passos).


## Ambientes de teste, homologação e produção
Existem alguns pré-requisitos para que o MS esteja funcional em teste, homologação e produção, estes são:

- Ter o arquivo **application.yml** removido do projeto, de maneira semelhante ao que foi [citado anteriormente](#eof).


- Um novo arquivo com o nome do microsserviço deve ser criado nas branches **test**, **dev** e **master** do projeto
[microservice-properties-v2](https://bitbucket.org/softfocusbr/microservice-properties-v2/)


- Ter as variáveis de ambiente preenchidas (que ficam separadas em 2 arquivos na pasta [bitbucket](k8s/bitbucket))
  * O [configmap.yaml](k8s/bitbucket/configmap.yaml) detém as variáveis não sensíveis, como hosts e portas.
  * O [secrets.yaml](k8s/bitbucket/secrets.yaml) detém as varíaveis sensíveis como senhas e tokens.


- O arquivo [bitbucket-pipelines](bitbucket-pipelines.yml), configurado:
  * Substituir a palavra "hexagonal" pelo nome do microservice.
  * Substituir a porta "8103" pela porta designada para o MS.
  * Definir valores para as variáveis utilizadas no arquivo de properties, dentro da tag step -> script dentro de cada ambiente (dev, homologacao e produção) ex:
    ```
    - export MICROSERVICE_NAMESPACE="default"
    - export MICROSERVICE_NAME="microservice-sanscrito"
    - export DATABASE_URL="192.168.50.108"
    - export DATABASE_NAME="microservices"
    - export DATABASE_SCHEMA="sanscrito"
    - export DATABASE_USER="microservices"
    - export MICROSERVICE_PORT="8103"
    - export RABBITMQ_USER="credifocus_hml"
    - export RABBITMQ_VHOST="credifocushomologacao"
    ```

## Informações extras

Na pasta [recursos-extras](recursos-extras) deve haver uma coleção com todos os endpoints do MS mapeados,
utilizando da variável ``{{url}}`` para ser possível o dinamismo do environment.

Na raiz desta coleção, existe a configuração de autenticação, somente será necessário informar um usuário e senha
para obter o token uma vez para a pasta, e as requests estarão a compartilhá-lo.
