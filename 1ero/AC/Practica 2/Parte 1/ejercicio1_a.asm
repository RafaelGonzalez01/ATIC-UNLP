PB EQU 31h 
CB EQU 33h

ORG 2000H 

mov al, 0b
out CB, al 
mov al, 0Fh 
out PB, al 
int 0 
end  