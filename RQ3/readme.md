# Efficiency and Functionality Evaluation

To demonstrate the advantages of our Sparrow, we conduct a comprehensive comparison with the related works including CML and TA-SPESC which both employ ontology to model the LC and generate the SLC in Ethereum Solidity. 

## Overview

Sparrow is designed to translate Legal Contracts (LCs) into Smart Legal Contracts (SLCs) on the Ethereum blockchain with high efficiency and expressiveness. This repository contains the experimental setup, results, and comparative analysis that demonstrate Sparrow's advantages.

## Experimental Setup

We conducted experiments with a diverse set of LCs, including purchase, auction, and rent contracts, categorized by complexity levels: simple, regular, and complex. The complexity is defined by the presence of property rights, breach of contract clauses, and the intricacy of default resolution mechanisms.

## Functionality Comparison

Our functionality comparison examines the ability of Sparrow, CML, and TA-SPESC to express constraints and actions within LCs. The results, as shown in Table IX, highlight Sparrow's superior capability to handle complex structures involving multiple constraints and actions.

![Clause_structure_types](picture/tableIX.png)

### Key Observations:
- CML struggles with complex constraints (C6, C7) and auction actions (A2, A3).
- TA-SPESC faces challenges in representing certain constraints (C2, C4, C7) and actions (A2, A3, A7).
- Sparrow adeptly manages complex expressions, showcasing its robust ontology design.

## Efficiency Comparison

Efficiency was assessed using objective criteria such as Proportion of Clauses (POC), Line Conversion Rate (LCR), and AST Conversion Rate (ACR). The results, detailed in Table V, indicate Sparrow's efficiency in modeling and code generation.

### Key Metrics:
- **POC**: Measures the complexity of contract modeling capabilities.
- **LCR**: Indicates the degree of redundancy in the code.
- **ACR**: Reflects the efficiency of the development process.

## Results and Comparison

Sparrow demonstrates a higher POC, lower LCR, and ACR compared to CML and TA-SPESC, indicating its enhanced reusability and concise code generation. The average translation metrics per specification line and AST node are as follows:
- CML: 3.07 lines and 21.32 AST nodes.
- TA-SPESC: 4.39 lines and 17.62 AST nodes.
- Sparrow: 2.61 lines and 11.41 AST nodes.

## Conclusion

The experimental results validate Sparrow's efficiency and functionality, showcasing its ability to generate more concise SLCs with reduced gas consumption while accurately expressing the functionality of LCs.
