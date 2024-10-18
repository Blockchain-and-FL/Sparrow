
# Residential Lease Agreement (RLA) Case Study

## Overview

This repository showcases a case study demonstrating how to translate a Residential Lease Agreement (RLA) into a Smart Contract (SC) using our Sparrow framework. The case study includes a detailed description of the RLA, its Specification Language Contract (SLC) representation, and the automatically generated Solidity smart contract, complete with deployment tests.

## Table of Contents

- [RLA Overview](#rla-overview)
- [Specification of RLA](#specification-of-rla)
- [Generated Smart Contract](#generated-smart-contract)
- [Deployment Test](#deployment-test)

## RLA Overview

The RLA utilized in this case study is based on the version referenced in [SPESC-translator](#), enhanced with additional roles and terms that are typically included but often overlooked. The RLA comprises the following key components:

- **Service Terms**: Obligations such as initial payments, property delivery, and monthly rent.
- **Default Terms**: Conditions triggered by delays, including late house delivery and rent payments.
- **Termination Terms**: Circumstances under which the lease may be terminated, such as significant delays or property damage.
- **Additional Terms**: Regulatory oversight and arbitration processes independent of external events.

## Specification of RLA

The SLC specification simplifies the modeling process by encapsulating redundant expressions of similar contractual clauses. The key components in the specification include:

- **Subjects**: Includes `Person` (RA, AA, RA) and `House` (Token).
- **Objects**: Comprising `deposit`, `rent`, and other financial details.
- **Conditions**: Such as `isDone` and `isTime`.
- **Operations**: Triggered by `transfer` or `assign`.

### Example SLC Specification



## Generated Smart Contract

The SLC specification is automatically translated into Solidity, adhering to predefined rules without the need for manual refinement. The generated smart contract of RLA is at HouseRent.sol.

### Key Features
Efficient mapping of roles and obligations to Solidity structs.
Automatic generation of payment and delivery functions.
Clear event emission for state transitions.

## Deployment Test
We conducted deployment tests to validate the generated SC against the original LC. Using Remix IDE, the SC was compiled and deployed on Ethereum. The flowchart illustrates the business process of the RLA.

Test Parameters
The parameters for the RLA case study are outlined in the accompanying tables, which include details on involved parties, payments, and lease dates.
process.png

### Test Scenarios
Initial Payment: The tenant pays the first rent and deposit.
House Delivery: The landlord delivers the house.
Regular Rent Payments: The tenant makes regular rent payments.
Late Payments and Penalties: Late payments trigger penalties and contract pauses.
Contract Expiration: The contract expires, and actions to reclaim the deposit are executed.

### Test Results
The tests confirm the correct execution of the contract logic. Below are some results:

Gas consumption analysis shows trends in transaction costs, indicating the efficiency of operations.

Conclusion
This case study successfully demonstrates the translation of a Residential Lease Agreement into a Smart Contract using the Sparrow framework, highlighting the advantages of automated contract generation. The generated SC operates seamlessly on Ethereum, adhering to the intended contractual logic.
