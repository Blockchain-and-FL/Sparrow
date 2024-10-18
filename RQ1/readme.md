
# Modeling and Development Effectiveness Evaluation

## Experimental Objective
The primary objective of our experiments was to assess the modeling and development effectiveness of Sparrow.

## Methodology
We constructed an evaluation dataset comprising 10 general LC types, including various lease and purchase contracts. The contracts were implemented in Sparrow and the generated SCs were evaluated for functionality and security.


## Key Findings

### Modeling Effectiveness(Table V)
- Sparrow successfully demonstrated the ability to express all defined legal elements and logical structures within the LCs.
- The framework showed high completeness in terms of legal element expression and logical expressiveness.

### Development Effectiveness(Table V)
- Sparrow generated SCs with a high degree of function integrity and security, without functional post-refinement.
- The average function conversion rate was 2.18, indicating a strong correspondence between rules and functions.
  
![effectiveness_eval](../picture/tableV.png)

### Security Analysis
![sec_eval](../picture/tableVI.png)
- Using tools like Mythril, Smartcheck, and Slither, we identified vulnerabilities such as reentrancy and timestamp dependency in the generated SCs.
  
   **Reentrancy**: Identified due to publicly visible functions that could be transferred before assignments are completed.
  
   **Timestamp Dependency**: Caused by the direct use of blockchain timestamps, which can be manipulated in certain conditions.
  
- Sparrow's design allows for fixed revision patterns and integration of an independent clock provided by an internal system or a time oracle to address these security concerns, ensuring the generated smart contracts can be made more secure with refinement.

## Conclusion
Sparrow demonstrates the enhanced capability in expressiveness and a high level of development effectiveness, producing SCs that are largely free from the need for functional post-refinement. However, identified security vulnerabilities highlight the need for careful consideration in the design and implementation phases to ensure the generated SCs are secure.
