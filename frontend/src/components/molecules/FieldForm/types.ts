import { InputFieldFormProps } from '../../atoms/InputFieldForm/types';

export interface FieldFormProps extends InputFieldFormProps {
  title: string;
  getData?: any;
}