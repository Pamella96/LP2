#include <stdio.h>
#include <stdlib.h>

typedef struct no {
    char name[40];
    int code;
    double preco;
    struct no *prox;
}no;

no *inicioL = NULL;

void inicializarLista(){
    inicioL= NULL;
}

int listaVazia(){
    if (inicioL == NULL){
        return 1;
    }else{
        return 0;
    }
}

void inserir_fim(int valor, char nome[40], double price){
    int i;
    no *aux, *p;
    aux=(no*)malloc(sizeof(no));
    if(aux!=NULL){
        aux->code= valor;


        for (i=0; i<40; i++){
                aux->name[i]= nome[i];

        }
        aux ->preco = price;
        aux->prox= NULL;
        if(!listaVazia()){
            p= inicioL;
            while(p->prox != NULL){
                p= p->prox;
            }
            p->prox= aux;
        }
        else{
            inicioL = aux;
        }


    }
}

void percorrer(){
    no *aux;
    if(!listaVazia()){
        aux = inicioL;
        while(aux!=NULL){
            printf("\nCodigo do produto: %d", aux->code);
            printf("\nNome do produto: %s", aux-> name);
            printf("\nPreço do produto: %f", aux-> preco);
            aux = aux-> prox;
        }
    }
    else{
        printf("\nLista vazia\n");
    }
}

void busca(int valor){
    no *aux;
    aux = inicioL;
    if(!listaVazia()){
        while(aux != NULL && aux -> code != valor){
            aux = aux -> prox;
        }
        if(aux == NULL){
            printf("\nNao encontrado");
        }
        else{
            printf("\nCodigo do produto: %d", aux->code);
            printf("\nNome do produto: %s", aux->name);
            printf("\nPreço do produto: %f", aux->preco);
        }
    }
    else{
        printf("vazio");
    }

}

void remover(int valor){
    no *aux, *ant;
    aux = inicioL;
    ant = NULL;
    if(!listaVazia()){
        while(aux != NULL && aux ->code!= valor){
            ant = aux;
            aux = aux->prox;
        }
        if(aux == NULL){
            printf("\nNao encontrado");
        }
        else{
            if(ant == NULL){
                inicioL = aux->prox;
            }
            else{
                ant->prox = aux->prox;
            }
            free(aux);
        }
    }
    else{
        printf("\nVazio");
    }
}

int main()
{
    int valor, op;
    double price;
    char nome[40];
    inicializarLista();
    do{
        printf("\n 1 - cadastrar: \n 2 - exibir \n 3 - buscar \n 4 - remover \n 5 - sair");
        printf("\n informe opcao:");
        scanf("%d", &op);
        if(op != 1 && op != 2 && op!= 3 && op!= 4 && op!= 5){
            printf("\ninvalido");
        }
        else{
            if(op ==1){
                printf("\ncodigo:");
                scanf("%d", &valor);
                printf("\n nome:");
                fflush(stdin);
                fgets(nome,40, stdin);
                printf("\n preco:");
                fflush(stdin);
                scanf("%f", &price);
                inserir_fim(valor, nome, price);
            }
            else if(op==2){
                percorrer();
            }
            else if(op==3){
                printf("\n codigo:");
                scanf("%d", &valor);
                busca(valor);
            }
            else if(op==4){
                printf("\ncodigo remover:");
                scanf("%d", &valor);
                remover(valor);
            }
            else{
                printf("\nfim");
            }
        }
    }while(op!=5);
    return 0;
}
