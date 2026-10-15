PA EQU 30h
CA EQU 32h 

ORG 1000h

msj db "Apagadas" 

ORG 2000H 

mov al, 0FFh 
out CA, al 
in al, PA 
cmp al, 0 
jnz fin 
mov al, 8 
mov bx , offset msj 
int 7 
fin: int 0 
end