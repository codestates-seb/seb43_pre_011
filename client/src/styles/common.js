import styled from "styled-components";

export const BtnBlueLine = styled.button`
  padding: 8px 10.4px;
  margin: 2px;
  border: 1px solid rgb(122, 167, 199);
  border-radius: 3px;
  box-shadow: rgba(255, 255, 255, 0.698) 0px 1px 0px 0px inset;
  color: rgb(57, 115, 157);
  background-color: rgb(225, 236, 244);

  &:hover {
    background-color: hsl(205, 57%, 81%);
    color: hsl(205, 46%, 32%);
  }
`;

export const BtnBlueFill = styled(BtnBlueLine)`
  border-color: rgb(122, 167, 199);
  color: rgb(255, 255, 255);
  background-color: rgb(10, 149, 255);

  &:hover {
    background-color: hsl(206, 100%, 40%);
    color: hsl(0, 0%, 100%);
  }
`;
