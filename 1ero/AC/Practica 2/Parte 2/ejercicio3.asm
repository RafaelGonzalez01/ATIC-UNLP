PA EQU 30h 
CA EQU 32h 
ORG 1000h 

ORG 2000H 
mov al, 00000001b 
out CA, al    
int 0 

ORG 3000h
flanco_ascendente: push ax
mov al 00000000b
out PA,al
mov al 00000010b
out PA,al
pop ax
ret
end 