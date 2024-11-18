export interface Corporation {
      id: string | null | undefined;
      name: string | null | undefined;
      category: string | null | undefined;
      description: string | null | undefined;
      adress: {
            street: string | null | undefined,
            number: string | null | undefined,
            neighborhood: string | null | undefined
      };
      hours: string | null | undefined;
      phoneNumber: string | null | undefined;
}