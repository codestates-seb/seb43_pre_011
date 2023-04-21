import styled from "styled-components";

const Box = styled.div`
  .box {
    display: flex;
    flex-direction: column;
    width: 316px;
    @media screen and (max-width: ${BREAKPOINT.tablet}) {
      width: 268px;
    }
    padding: 24px;

    background-color: white;
    box-shadow: 0 10px 24px hsla(0, 0%, 0%, 0.05),
      0 20px 48px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.1);
    border-radius: 5px;
  }
`;

const InputBox = styled.div`
  display: flex;
  padding-top: 6px;

  .title {
    font-size: 2rem;
    font-weight: 700;
  }
  .input {
    width: 2868.012px;
    height: 32.2567px;
    border: 3px;
    border-color: hsl(210deg 8% 65%);
  }
  .message {
    font-size: 1.5rem;
    font-weight: 400;
    color: hsl(210deg 8% 65%);
  }
`;
