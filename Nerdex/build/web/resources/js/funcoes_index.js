/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function login(id, nome,endereco,fone){
    var cliente = new Object();
    
    cliente.id = id;
    cliente.nome = nome;
    cliente.endereco = endereco;
    cliente.fone = fone;
    
    sessionStorage.setItem('cliente',JSON.stringify(cliente));
    
    
}