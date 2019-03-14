#language: pt
Funcionalidade: Login

  Cenário: Realizar login
    Dado que eu esteja na tela de login
    Quando fazer login com o usuário "mercury" e senha "mercury"
    Então sou atenticado com sucesso
