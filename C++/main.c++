#include <iostream>
#include <string>

using namespace std;
//field Variables
const int lengX = 5;
const int lengY = 5;
//snakes Varibles
int posX = 3-1;
int posY = 3-1;
int direction = 1; // 1 = up 2 = right 3= down 4 = left
const int LengS = 2;

std::string feld[lengX][lengY];

void inFeld (){
    for(int i = 0; i < lengX; i++){
        for(int j = 0; j < lengX; j++){
            feld[i][j] = "[ ] ";
        }    }
}

void printFeld(){
    for(int i = 0; i < lengX; i++){
        for(int j = 0; j < lengX; j++){
          printf("%s", feld[i][j].c_str());
        }
        printf("\n");
    }
}

void initSnakeBody(){
    for (int i = 1; i < LengS; i++){
        if(direction == 1){
            feld[posX+i][posY] = "[O] ";
        }
        if(direction == 2){
            feld[posX][posY-i] = "[O] ";
        }
         if(direction == 3){
            feld[posX-i][posY] = "[O] ";
        }
         if(direction == 4){
            feld[posX][posY+i] = "[O] ";
        }
    }
    
}

void initSnakePosition(){
    feld[posY][posY] = "[X] ";
    initSnakeBody();
    }

void checkNextMove(){
    switch(direction){
        case 1:
            if(feld)
        break;
        case 2:
        break;
        case 3:
        break;
        case 4:
        break;
    }
}

void moveSnake(){
    checkNextMove();
}

int main()
{
    printf("Spielfeld wird Erstellt... \n");
    inFeld();
    printFeld();
    printf("Schlange wird erstellt... \n");
    initSnakePosition();
    printFeld();

    for (int i = 0; i < 5; i++){    
        moveSnake();
        printFeld();
        printf("%d", i);
        printf("\n");
        //timer
    }
    return 0;
}