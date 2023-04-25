import { useState } from "react";
import styled from "styled-components";

const StyledFilter = styled.div`
  display: flex;
  border: 1px solid var(--header-gray);
  border-radius: 3px;

  button {
    padding: 1rem;
    border-right: 1px solid var(--header-gray);
    cursor: pointer;
    color: var(--gray);

    &:last-of-type {
      border-right: 0;
    }

    &.selected {
      background-color: var(--hover-gray);
      color: var(--black);
    }

    .blue {
      background-color: var(--link);
      color: var(--white);
      font-size: 1.1rem;
      padding: 0 0.4rem;
      border-radius: 3px;
    }
  }
`;

const Filter = () => {
  const filterType = ["Newest", "Active", "Bountied", "Unanswered"];
  const [selected, setSelected] = useState(0);

  const onSelect = (idx) => {
    setSelected(idx);
  };

  return (
    <StyledFilter>
      {filterType.map((type, idx) => (
        <button
          type="button"
          key={idx}
          className={selected === idx ? "selected" : ""}
          onClick={() => onSelect(idx)}
        >
          {type}
        </button>
      ))}
    </StyledFilter>
  );
};

export default Filter;
