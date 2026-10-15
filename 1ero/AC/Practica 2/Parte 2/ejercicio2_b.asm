PA EQU 30h 
CA EQU 32h 
ORG 1000h 
si db “Ocupada” 
no db “Libre” 
ORG 2000H 
mov al, 00000001b 
out CA, al 
loop: in al, PA 
and al, 00000001b
jnz loop
mov bx, offset no 
mov al, 5 
int 7
fin:     
int 0 
end 