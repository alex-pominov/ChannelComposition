# Composition example for Channel Model PIM8 version @prodexa

## Introduction

Current implementation of projected fields is over engineering. In this repository I tried to create flexible channel structure, that are open to changes.
If we want to add new projection filed to channel, then we just extend **ColumnProjectionDecorator** class. In this case we don't need any DTO classes to 
manage projection fields - all control mechanism comes with an instance. 

## Advantages  
- flexibility;
- following open/closed principle;
- no need extra transform classes like DTO;



