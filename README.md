# <h1 align="center"> Attornatus - Avaliação BackEnd </h1>
<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

### Projeto

##### Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:
- [X] Criar uma pessoa 
- [X] Editar uma pessoa 
- [X] Consultar uma pessoa 
- [X] Listar pessoas 
- [X] Criar endereço para pessoa 
- [X] Listar endereços da pessoa 
- [X] Poder informar qual endereço é o principal da pessoa

Uma Pessoa deve ter os seguintes campos: 
<pre>
{
    "nome": "Bruno Lutterbach",
    "dataNascimento": "17/11/2000",
    "enderecos": [
        {
            "logradouro": "Rua Ulisses Lengruber",
            "cep": "28640-000",
            "numero": "383",
            "cidade": "Carmo"
        }
    ]
}
</pre>

#

#### URL Deploy
> https://attornatusavaliacao.herokuapp.com/

#

### Rotas
#
### 1 Pessoas
#### 1.1 Cadastrar Pessoa
| Método | Rota | Descrição | JSON | 
| --- | --- | --- | --- | 
|POST | /pessoas | Cadastrar uma pessoa. <br> É possível cadastrar uma pessoa sem endereços<br> ou com 1 ou mais endereços.<br> O primeiro endereço do json é sempre setado<br> como principal | <pre>{<br> "nome": "Bruno Lutterbach",<br> "dataNascimento": "17/11/2000",<br> "enderecos": [<br>       {<br>          "logradouro": "Rua Ulisses Lengruber",<br>          "cep": "28640-000",<br>          "numero": "383",<br>          "cidade": "Carmo"<br>       },<br>       {<br>          "logradouro": "Rua Ulisses Lengruber",<br>          "cep": "28640-000",<br>          "numero": "175",<br>          "cidade": "Carmo"<br>       }<br>   ]<br>}  </pre> |

| Nome  | Descrição | 
| --- | --- | 
|nome | Obrigatório | 
|dataNascimento  | Obrigatório | 
|[enderecos] | Opcional | 
|logradouro | Obrigatório | 
|cep | Obrigatório | 
|numero | Obrigatório | 
|cidade | Obrigatório | 

![image](https://user-images.githubusercontent.com/95001637/213813790-e695b72c-72d9-4836-9bf4-cd9ed09209e3.png)

#
#### 1.2 Atualizar Pessoa

| Método | Rota | Descrição | JSON | 
| --- | --- | --- | --- | 
|PUT | /pessoas | Atualizar uma pessoa | <pre>{<br> "nome": "Bruno Lutterbach Pereira Marques"<br>}</pre> |

| Nome  | Descrição | 
| --- | --- | 
|nome | Opcional | 
|dataNascimento  | Opcional | 

![image](https://user-images.githubusercontent.com/95001637/213814341-33f62e9f-e7fe-4ee1-9f6d-c8b71759029f.png)

#
#### 1.3 Consultar Pessoa por ID

| Método | Rota | Descrição | 
| --- | --- | --- | 
|GET | /pessoas/{id} | Retornar uma pessoa por id |

![image](https://user-images.githubusercontent.com/95001637/213814524-5c9b5b66-b721-4090-b3d3-8c4f5f55354a.png)

#
#### 1.4 Consultar Pessoas e seus Endereços por ID

| Método | Rota | Descrição | 
| --- | --- | --- | 
|GET | /pessoas/{id}/enderecos | Retornar todas as pessoas e seus endereços por id 

##### Ordenação
```
localhost:8080/pessoas/enderecos?sort=id,desc
```
##### Paginação
```
localhost:8080/pessoas/enderecos?page=0&size=2
```

![image](https://user-images.githubusercontent.com/95001637/213815367-e8538b16-7625-4213-ab08-790e95d31add.png)


#
#### 1.5 Consultar Pessoa e seus Endereços por ID

| Método | Rota | Descrição | 
| --- | --- | --- | 
|GET | /pessoas/{id}/enderecos | Retornar uma pessoa e seus endereços por id |

![image](https://user-images.githubusercontent.com/95001637/213814613-01427689-fddf-40ee-a61a-313514e11cff.png)

#
#### 1.6 Deletar Pessoa
| Método | Rota | Descrição |
| --- | --- | --- |
|DEL | /pessoas/{id} |Deletar pessoa por id e seus endereços |

![image](https://user-images.githubusercontent.com/95001637/213816148-ecfd979c-e655-4c19-8ba7-f1ae2c3990ff.png)

#
### 2 Endereços
#### 2.1 Cadastrar Endereco
| Método | Rota | Descrição | JSON | 
| --- | --- | --- | --- | 
|POST | /endereco | Cadastrar um endereço | <pre>{<br>       "logradouro": "Rua Ulisses Lengruber",<br>       "cep": "28640-000",<br>       "numero": "383",<br>       "cidade": "Carmo"<br>}</pre> |

| Nome  | Descrição | 
| --- | --- | 
|logradouro | Obrigatório | 
|cep | Obrigatório | 
|numero | Obrigatório | 
|cidade | Obrigatório | 

![image](https://user-images.githubusercontent.com/95001637/213816710-ba45b2b7-5123-4c5e-b4e0-c0ea59fec069.png)

#
#### 2.2 Atualizar Endereço
| Método | Rota | Descrição | JSON | 
| --- | --- | --- | --- | 
|PUT | /endereco/{id} | Atualizar um endereço | <pre>{<br>     "cep": "12345-000",<br>      "numero": "2579",<br>}</pre> |

| Nome  | Descrição | 
| --- | --- | 
|logradouro | Opcional | 
|cep | Opcional | 
|numero | Opcional | 
|cidade | Opcional |

![image](https://user-images.githubusercontent.com/95001637/213816917-ed07ef9c-74da-4999-b3ec-d136248373c8.png)

#
#### 2.3 Tornar Endereço principal
| Método | Rota | Descrição | JSON | 
| --- | --- | --- | --- | 
|PATCH | /endereco/{id} | Atualizar um endereço | |

![image](https://user-images.githubusercontent.com/95001637/213817128-8fd4bbe6-d17c-454e-af57-7f5e090a4c9b.png)
![image](https://user-images.githubusercontent.com/95001637/213817177-f6a8876b-21c2-41b4-abf6-547a4d69418c.png)

#
#### 2.4 Deletar Endereço
| Método | Rota | Descrição | JSON | 
| --- | --- | --- | --- | 
|DEL | /endereco/{id} | Deletar um endereço | |

![image](https://user-images.githubusercontent.com/95001637/213817307-9f085a92-7e52-4951-b85b-b9055c9f1eb2.png)

#
### Validações

Validação ao cadastrar Pessoa/Endereço com campos em branco

![image](https://user-images.githubusercontent.com/95001637/213817588-93a3f43a-8649-45e2-844e-49fee762f36f.png)
![image](https://user-images.githubusercontent.com/95001637/213817616-a86fc421-01ac-43f5-8743-5c329ba61a30.png)

Validação ao buscar Pessoa com ID inexistente.

![image](https://user-images.githubusercontent.com/95001637/213817674-2d3934f2-e4d3-43d4-bd86-9435137010ae.png)

Validação ao deletar Endereço Principal

![image](https://user-images.githubusercontent.com/95001637/213817502-a33ae4c8-9d4b-480d-b73c-2dad918a3ecf.png)
![image](https://user-images.githubusercontent.com/95001637/213817796-d39866d4-7dd7-44f8-be4b-807497c87984.png)






























