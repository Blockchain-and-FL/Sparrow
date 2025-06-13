# RQ2: Efficiency of Sparrow
The efficiency of Sparrow is evaluated based on four primary criteria: **line conversion rate**, **byte conversion rate**, and **gas consumption**. 

![eff_eval](../picture/tableVII.png)

## Efficiency Evaluation Criteria

1. **Line Conversion Rate (LCR)**: This is calculated as the ratio of Effective Lines of Code (ELOC) to Effective Lines of Specification (ELOS). A higher LCR indicates that more code can be derived from fewer lines of specification.
2. **Byte Conversion Rate (BCR)**: This ratio is derived from Effective Bytes of Code (EBOC) to Effective Bytes of Specification (EBOS). The BCR is often more reliable than the LCR as it provides a more precise measure of redundancy in the code.
3. **Gas Consumption**: Gas consumption including transaction cost and execution cost is output by Remix IDE, reflecting the resources required for deploying and executing smart contracts on the Ethereum blockchain.

### Key Findings
From our evaluation, we observe the following:

- The degree of redundancy in the SLC specification can be quantified by EBOS and ELOS, while redundancy in the SC can be measured by ELOC and EBOC.
- Gas consumption is quantified with an average transaction cost of **3,614,798** and an average execution cost of **3,484,148**. While gas consumption is primarily determined by runtime operations, higher ELOC, EBOC, and AST values, as shown in Table V and Table VII, typically correlate with increased gas costs, as they may indicate more complex or repetitive code structures requiring additional computational resources.


## Conclusion
The evaluation results indicate that Sparrow demonstrates efficient performance in converting LCs into SCs, making it a practical tool for automating this process. 

