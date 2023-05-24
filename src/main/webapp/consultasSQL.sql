#CONSULTAS SQL


#Ordenados  poe nombre de usuario

SELECT  Usuario.IdUsuario, Usuario.name, Usuario.surname,  Usuario.nameUsuario,  Usuario.contra,  Usuario.correo, Usuario.picture, Usuario.admin, Company.nameCompany, Departament.nameDepartament 
FROM  Usuario  LEFT JOIN  Company ON Usuario.idCompany = Company.idCompany  
LEFT JOIN  Departament ON Usuario.idDepartament = Departament.idDepartament;
ORDER BY  Usuario.name



#Ordenados Por apellidos de Usuario
SELECT  Usuario.IdUsuario, Usuario.name, Usuario.surname,  Usuario.nameUsuario,  Usuario.contra,  Usuario.correo, Usuario.picture, Usuario.admin, Company.nameCompany, Departament.nameDepartament 
FROM  Usuario  LEFT JOIN  Company ON Usuario.idCompany = Company.idCompany  
LEFT JOIN  Departament ON Usuario.idDepartament = Departament.idDepartament;
ORDER BY  Usuario.surname


#Ordenados Por nombre de Usuario
SELECT  Usuario.IdUsuario, Usuario.name, Usuario.surname,  Usuario.nameUsuario,  Usuario.contra,  Usuario.correo, Usuario.picture, Usuario.admin, Company.nameCompany, Departament.nameDepartament 
FROM  Usuario  LEFT JOIN  Company ON Usuario.idCompany = Company.idCompany  
LEFT JOIN  Departament ON Usuario.idDepartament = Departament.idDepartament;
ORDER BY  Usuario.nameUsuario

#Ordenados Por nombre de Empresa
SELECT  Usuario.IdUsuario, Usuario.name, Usuario.surname,  Usuario.nameUsuario,  Usuario.contra,  Usuario.correo, Usuario.picture, Usuario.admin, Company.nameCompany, Departament.nameDepartament 
FROM  Usuario  LEFT JOIN  Company ON Usuario.idCompany = Company.idCompany  
LEFT JOIN  Departament ON Usuario.idDepartament = Departament.idDepartament;
ORDER BY  Company.nameCompany

#Ordenados Por nombre departamento
SELECT  Usuario.IdUsuario, Usuario.name, Usuario.surname,  Usuario.nameUsuario,  Usuario.contra,  Usuario.correo, Usuario.picture, Usuario.admin, Company.nameCompany, Departament.nameDepartament 
FROM  Usuario  LEFT JOIN  Company ON Usuario.idCompany = Company.idCompany  
LEFT JOIN  Departament ON Usuario.idDepartament = Departament.idDepartament;
ORDER BY  Departament.nameDepartament

# CREATE SQL

INSERT INTO Usuario name,surname, nameUsuario, contra, correo, picture, admin, idDepartament, idCompany VALUES ?,?,?,?,?,?,?,?,?


#MODIFICAR SQL




#ELIMINAR SQL




