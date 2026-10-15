
        org 1000h
PA      equ 30h
PB      equ 31h
CA      equ 32h
CB      equ 33h

        org 2000h

        mov al, 00000000b
        out CB, al
        mov al, 11111111b
        out CA, al

loop:   mov al, 0ffh
        out PB, al
        in al, PA
        cmp al, 0
        jnz loop
        
        hlt
        
        end